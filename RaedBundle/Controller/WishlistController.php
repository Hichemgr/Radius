<?php
/**
 * Created by PhpStorm.
 * User: raedm
 * Date: 17-Apr-19
 * Time: 15:31
 */

namespace SlimBundle\Controller;
use SlimBundle\Entity\Wishlist;
use SlimBundle\Form\WishlistType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use AppBundle\Form\FormValidationType;


class WishlistController extends Controller
{
    public function wishlistAction()
    {
        $proj = $this->getDoctrine()->getRepository(Wishlist::class)->findAll();
        return $this->render('@Slim/Front/wishlist.html.twig',array('proj'=>$proj));
    }
    public function ajouterwishlistAction ($nomproduit)
    {
        $Wishlist = new wishlist();
        $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
        $idd= $this->getUser()->getId() ;
        $Wishlist->setCin($idd);
        $Wishlist->setNom($nomproduit);
        $Wishlist->setPrix(4.5);
        $article=(new \DateTime('now'));
        $Wishlist->setDateajout($article);


        $em = $this->getDoctrine()->getManager();
            $em->persist($Wishlist);
            $em->flush();
        $proj = $this->getDoctrine()->getRepository(Wishlist::class)->findAll();
        return $this->render('@Slim/Front/wishlist.html.twig',array('proj'=>$proj));

    }
    public function supprimerWishlistAction($idwishlist)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Wishlist::class)->find($idwishlist);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("slim_homepagefrontwishlist");
    }

}