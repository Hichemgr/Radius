<?php

namespace HichemBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Panier
 *
 * @ORM\Table(name="panier", indexes={@ORM\Index(name="idutilisateur", columns={"idutilisateur"})})
 * @ORM\Entity(repositoryClass="HichemBundle\Repository\PanierRepository")
 */
class Panier
{
    /**
     * @return string
     */
    public function getEtat()
    {
        return $this->etat;
    }

    /**
     * @param string $etat
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;
    }

    /**
     * @return mixed
     */
    public function getIdutilisateur()
    {
        return $this->idutilisateur;
    }

    /**
     * @param  mixed $idutilisateur
     */
    public function setIdutilisateur($idutilisateur)
    {
        $this->idutilisateur = $idutilisateur;
    }
    /**
     * @var integer
     *
     * @ORM\Column(name="idpanier", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idpanier;

    /**
     * @return int
     */
    public function getIdpanier()
    {
        return $this->idpanier;
    }

    /**
     * @param int $idpanier
     */
    public function setIdpanier($idpanier)
    {
        $this->idpanier = $idpanier;
    }

    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=50, nullable=false)
     */
    private $etat;

    /**
     *
     * @ORM\ManyToOne(targetEntity="Utilisateur")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idutilisateur", referencedColumnName="idutilisateur")
     * })
     */
    private $idutilisateur;




}

